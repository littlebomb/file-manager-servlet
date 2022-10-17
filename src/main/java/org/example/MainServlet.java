package org.example;

import org.example.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        UserService user = db.userRepository.getUserFromCookie(req.getCookies());
        if (user != null) {
            String path = req.getParameter("path");
            if (path == null) path = "/home/xfcedos/users/" + user.getLogin();
            String homePath = "/home/xfcedos/users/" + user.getLogin();
            if (homePath.length() <= path.length()) {
                path = path.replaceAll("%20", " ");
                File file = new File(path);
                if (!file.exists()) file.mkdir();
                if (file.isDirectory()) {
                    showFiles(req, file);
                    req.setAttribute("date", new SimpleDateFormat("dd/MM/yy, hh:mm:ss").format(new Date()));
                    req.setAttribute("path", path);
                    req.setAttribute("parent", new File(path).getParent());
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("fileManager.jsp");
                    requestDispatcher.forward(req, resp);
                } else downloadFile(resp, file);
            } else resp.sendRedirect("/denied");
        } else resp.sendRedirect("/login");
    }

    private List<File> getFiles(File[] files){
        return Arrays.stream(files).sorted().filter(File::isFile).collect(Collectors.toList());
    }

    private List<File> getDirectories(File[] files){
        return Arrays.stream(files).sorted().filter(File::isDirectory).collect(Collectors.toList());
    }

    private void showFiles(HttpServletRequest req, File file) {
        File[] files = file.listFiles();
        if (files != null) {
            req.setAttribute("files", getFiles(files));
            req.setAttribute("directories", getDirectories(files));
        }
    }

    private void downloadFile(HttpServletResponse resp, File file)
        throws IOException {
        resp.setContentType("text/html");
        resp.setHeader("Content-disposition", "attachment; filename=" + file.getName());

        FileInputStream in = new FileInputStream(file);
        OutputStream out = resp.getOutputStream();
        byte[] buffer = new byte[4096];
        int size;
        while ((size = in.read(buffer)) > 0) out.write(buffer, 0, size);
        in.close();
        out.flush();
    }
}
