/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */

package unlock;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * The controller for our 'Unlock' application, see 'Unlock.fxml'.
 * This class has all the logic to open the theater's doors using JavaFX
 * transitions.
 */
public class UnlockController {

    private final String PIN = "1234";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Node root;

    @FXML // fx:id="pad"
    private Node pad; // Value injected by FXMLLoader

    @FXML // fx:id="del"
    private Button del; // Value injected by FXMLLoader

    @FXML // fx:id="error"
    private Rectangle error; // Value injected by FXMLLoader

    @FXML // fx:id="lock"
    private Button lock; // Value injected by FXMLLoader

    @FXML // fx:id="ok"
    private Button ok; // Value injected by FXMLLoader

    @FXML // fx:id="okleft"
    private Rectangle okleft; // Value injected by FXMLLoader

    @FXML // fx:id="okright"
    private Rectangle okright; // Value injected by FXMLLoader

    @FXML // fx:id="display"
    private PasswordField display; // Value injected by FXMLLoader

    @FXML // fx:id="unlockbottom"
    private Rectangle unlockbottom; // Value injected by FXMLLoader

    @FXML // fx:id="unlocktop"
    private Rectangle unlocktop; // Value injected by FXMLLoader

    private boolean open = false;
    private boolean unlocking = false;

    private final static class HeightTransition extends Transition {
        final Rectangle node;
        final double height;

        public HeightTransition(Duration duration, Rectangle node) {
            this(duration, node, node.getHeight());
        }

        public HeightTransition(Duration duration, Rectangle node, double height) {
            this.node = node;
            this.height = height;
            this.setCycleDuration(duration);
        }

        public Duration getDuration() {
            return getCycleDuration();
        }

        @Override
        protected void interpolate(double frac) {
            this.node.setHeight((1.0 - frac) * height);
        }

    }

    private final static class WidthTransition extends Transition {
        final Rectangle node;
        final double width;

        public WidthTransition(Duration duration, Rectangle node) {
            this(duration, node, node.getWidth());
        }

        public WidthTransition(Duration duration, Rectangle node, double width) {
            this.node = node;
            this.width = width;
            this.setCycleDuration(duration);
        }


        public Duration getDuration() {
            return getCycleDuration();
        }

        @Override
        protected void interpolate(double frac) {
            this.node.setWidth((1.0 - frac) * width);
        }

    }

    private FadeTransition fadeOut(final Duration duration, final Node node) {
        final FadeTransition fadeOut = new FadeTransition(duration, node);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                node.setVisible(false);
            }
        });
        return fadeOut;
    }

    // Handler for Button[fx:id="lock"] onAction
    @FXML
    void unlockPressed(ActionEvent event) {
        // handle the event here
        if (unlocking) {
            return;
        }
        unlocking = true;
        lock.setDisable(true);
        pad.setDisable(true);
        root.requestFocus();

        final FadeTransition fadeLockButton = fadeOut(Duration.valueOf("1s"), lock);
        final HeightTransition openLockTop = new HeightTransition(Duration.valueOf("2s"), unlocktop);
        openLockTop.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                unlocktop.setVisible(false);
                unlocktop.setHeight(openLockTop.height);
            }
        });

        final HeightTransition openLockBottom = new HeightTransition(Duration.valueOf("2s"), unlockbottom);
        openLockBottom.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                unlockbottom.setVisible(false);
                unlockbottom.setHeight(openLockBottom.height);
            }
        });
        final ParallelTransition openLock = new ParallelTransition(openLockTop, openLockBottom);
        final SequentialTransition unlock = new SequentialTransition(fadeLockButton, openLock);
        unlock.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                unlocking = false;
                pad.setDisable(false);
                ok.getParent().getChildrenUnmodifiable().iterator().next().requestFocus();
            }
        });
        unlock.play();
    }

    // Handler for Button[fx:id="del"] onAction
    // Handler for Button[fx:id="ok"] onAction
    // Handler for Button[id="digit"] onAction
    @FXML
    void keyPressed(ActionEvent event) {
        if (event.getTarget() instanceof Button && !unlocking) {
            if (event.getTarget() == del && !display.getText().isEmpty()) {
                delete();
            } else if (event.getTarget() == ok) {
                validate(display.getText());
            } else if (event.getTarget() != del) {
                append(((Button) event.getTarget()).getText());
            }
            event.consume();
        }

    }

    private void delete() {
        display.setText(display.getText().substring(0, display.getText().length() - 1));
    }

    private void append(String s) {
        String text = display.getText();
        if (text == null) {
            text = "";
        }
        display.setText(text + s);
    }

    private void resetVisibility() {
        pad.setOpacity(1.0);
        display.setOpacity(1.0);
        lock.setOpacity(1.0);
        pad.setVisible(true);
        pad.setDisable(true);
        display.setVisible(true);
        lock.setVisible(true);
        lock.setDisable(false);
        okright.setVisible(true);
        okleft.setVisible(true);
        unlocktop.setVisible(true);
        unlockbottom.setVisible(true);
    }

    // Handler for AnchorPane[id="AnchorPane"] onKeyPressed
    private void keyboardKeyPressed(KeyEvent event) {
        if (" ".equals(event.getCharacter())) {
            // When "Hello World" is displayed (the theater is open) - pressing
            // the space bar will reinitialize the application.
            if (open) {
                // Reinitializing the application...
                open = false;
                unlocking = false;
                resetVisibility();
                lock.requestFocus();
            }
        }
    }

    private void validate(String pin) {
        if (PIN.equals(pin)) {
            root.requestFocus();
            pad.setDisable(true);
            FadeTransition fadeOutPassword = fadeOut(Duration.valueOf("1s"), display);
            FadeTransition fadeOutPad = fadeOut(fadeOutPassword.getDuration(), pad);
            final WidthTransition openOkLeft = new WidthTransition(Duration.valueOf("2s"), okleft);
            openOkLeft.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent arg0) {
                    okleft.setVisible(false);
                    okleft.setWidth(openOkLeft.width);
                }
            });
            final WidthTransition openOkRight = new WidthTransition(openOkLeft.getDuration(), okright);
            openOkRight.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent arg0) {
                    okright.setVisible(false);
                    okright.setWidth(openOkRight.width);
                }
            });
            final ParallelTransition fadeOut =
                    new ParallelTransition(fadeOutPassword, fadeOutPad);
            final ParallelTransition openOk =
                    new ParallelTransition(openOkLeft, openOkRight);
            final SequentialTransition okTrans =
                    new SequentialTransition(fadeOut, openOk);
            okTrans.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent arg0) {
                    open = true;
                    root.requestFocus();
                }
            });
            okTrans.play();
        } else {
            FadeTransition errorTrans = new FadeTransition(Duration.valueOf("500ms"), error);
            errorTrans.setFromValue(0.0);
            errorTrans.setToValue(1.0);
            errorTrans.setCycleCount(2);
            errorTrans.setAutoReverse(true);
            errorTrans.play();
        }
        display.setText("");
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert del != null : "fx:id=\"del\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert error != null : "fx:id=\"error\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert lock != null : "fx:id=\"lock\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert ok != null : "fx:id=\"ok\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert okleft != null : "fx:id=\"okleft\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert okright != null : "fx:id=\"okright\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert pad != null : "fx:id=\"pad\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert unlockbottom != null : "fx:id=\"unlockbottom\" was not injected: check your FXML file 'Unlock.fxml'.";
        assert unlocktop != null : "fx:id=\"unlocktop\" was not injected: check your FXML file 'Unlock.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

        // reset visibility and opacity of nodes - usefull if you left your
        // FXML in a 'bad' states 
        resetVisibility();

        // Add event handler to the root - used to handle the space bar key at the
        // end of the application
        root.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (event instanceof KeyEvent) {
                    keyboardKeyPressed((KeyEvent) event);
                }
            }
        });
    }

}
