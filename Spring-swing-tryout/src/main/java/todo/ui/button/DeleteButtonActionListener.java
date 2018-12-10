package todo.ui.button;

import java.awt.event.ActionEvent;

/**
 * @author Vadym Mitin
 */
public class DeleteButtonActionListener extends ListTableActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        boolean tableNotEditing = !table.isEditing();
        boolean rightRowSelect = selectedRow != -1;

        if (rightRowSelect && tableNotEditing) {
            list.remove(selectedRow);
            table.revalidate();
        }
    }
}
