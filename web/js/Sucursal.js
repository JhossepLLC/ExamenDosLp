$(document).ready(() => {
    listarSucursal();
});

var sucursales = [];
const listarSucursal = () => {
    console.table("sucursales");
    $('#tblSucursal tbody tr').remove();
    $.get('SucursalController', {opcion: 1}, (data) => {


        sucursales = JSON.parse(data);
        console.table(sucursales);
        sucursales.forEach(
                (sucursal, id) => {
            $('#tblSucursal tbody').append(`
                    <tr>
                        <td>${id + 1}</td>
                        <td>${sucursal.nombreSucursal}</td>
                        <td>${sucursal.direccionSucursal}</td>
                        <td>${sucursal.estadoSucursal}</td>
                    </tr>
                `);
        });
    });
};