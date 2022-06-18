/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.upeu.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.dao.DetalleDao;
import pe.edu.upeu.daoImpl.DetalleDaoImpl;
import pe.edu.upeu.model.Detalle;
import pe.edu.upeu.model.Venta;

/**
 *
 * @author HP
 */
@WebServlet(name = "detalleVenta", urlPatterns = {"/detalleVenta"})
public class detalleVentaController extends HttpServlet {

    private DetalleDao detalleDao = new DetalleDaoImpl();
    private Gson gson = new Gson();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        switch (opcion) {

            case 1:
                out.println(gson.toJson(detalleDao.listarDetalles()));
                break;
            case 2: //Agregar

                String json = request.getParameter("ventaNueva");

                Venta ventaNuevas = gson.fromJson(json, Venta.class);

                String jsonDetalle = request.getParameter("detalleVenta");
                Detalle detalleVentaNueva = gson.fromJson(jsonDetalle, Detalle.class);
                
                int idVentaCreada = detalleDao.crearVenta(ventaNuevas);
                
                detalleDao.crearDetalleVenta(idVentaCreada, detalleVentaNueva);
                //productoDao.crearProducto(productoNuevo, productoDto.getIdCategoria());
                break;
              case 3:
                  int idVenta = Integer.parseInt(request.getParameter("idVentas"));
                out.println(gson.toJson(detalleDao.listarDetalleVenta(idVenta)));
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
