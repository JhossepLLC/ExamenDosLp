$(document).ready(() => {
    listarProductos();
});

var productos = [];
const listarProductos = () => {
    console.table("productos");
    $('#tblProducto tbody tr').remove();
    $.get('ProductoController', {opcion: 1}, (data) => {

        productos = JSON.parse(data);
        console.table(productos);
        productos.forEach(
                (empleado, id) => {
            $('#tblProducto tbody').append(`
                    <tr>
                        <td>${id + 1}</td>
                        <td>${empleado.nombreProductos}</td>
                        <td>${empleado.precioProductos}</td>
                        <td>${empleado.stockProductos}</td>
                        <td>${empleado.estadoProductos}</td>
                        <td>${empleado.nombreCategorias}</td>
                    </tr>
                `);
        }
        );
    });
};


