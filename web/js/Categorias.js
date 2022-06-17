$(document).ready(() => {
    listarCategoria();
});

var categorias = [];
const listarCategoria = () => {
    console.table("categorias");
    $('#tblCategoria tbody tr').remove();
    $.get('CategoriaController', {opcion: 1}, (data) => {

        categorias = JSON.parse(data);
        console.table(categorias);
        categorias.forEach(
                (categoria, id) => {
            $('#tblCategoria tbody').append(`
                    <tr>
                        <td>${id + 1}</td>
                        <td>${categoria.nombreCategoria}</td>
                        <td>${categoria.estadoCategoria}</td>
                    </tr>
                `);
        });
    });
};