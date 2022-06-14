$(document).ready(() => {
    listarEmpleado();
});

var empleados = [];
const listarEmpleado = () => {
    console.table("Profe Reyna Chupa gampi");
    $('#tblEmpleado tbody tr').remove();
    $.get('EmpleadosController', {opcion: 1}, (data) => {

        empleados = JSON.parse(data);
        console.table(empleados);
        empleados.forEach(
                (empleado, id) => {
            $('#tblEmpleado tbody').append(`
                    <tr>
                        <td>${id + 1}</td>
                        <td>${empleado.cargoEmpleados}</td>
                        <td>${empleado.nombrePersonas}</td>
                        <td>${empleado.apellidoPersonas}</td>
                        <td>${empleado.dniPersonas}</td>
                        <td>${empleado.telefonoPersonas}</td>
                    </tr>
                `);
        }
        );
    });
};
