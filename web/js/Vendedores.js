$(document).ready(() => {
    listarVendedores();
});

var vendedoreses = [];
const listarVendedores = () => {
    console.table("vendedoreses");
    $('#tblVendedores tbody tr').remove();
    $.get('VendedorController', {opcion: 1}, (data) => {

        vendedoreses = JSON.parse(data);
        console.table(vendedoreses);
        vendedoreses.forEach(
                (vendedor, id) => {
            $('#tblVendedores tbody').append(`
                    <tr>
                        <td>${id + 1}</td>
                        <td>${vendedor.nombrePersonas}</td>
                        <td>${vendedor.apellidoPersonas}</td>
                        <td>${vendedor.dniPersonas}</td>
                        <td>${vendedor.telefonoPersonas}</td>
                    </tr>
                `);
        });
    });
};