package com.wte;

import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Vadym Mitin
 */
public class SimpleServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        httpServletResponse.getWriter().print("Hello from servlet");
    }
}
