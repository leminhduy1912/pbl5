package com.pbl5.controller.Movie;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import static com.pbl5.utils.constants.Endpoint.*;

@WebServlet(urlPatterns = {V1  +ADMIN+ "/movie"})
@MultipartConfig
public class MovieController {
}
