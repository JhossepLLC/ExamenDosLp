$(document).ready(() => {
    listarVendedor();
    listarSucursal();
    listarCliente();
    listarProducto();
    listarRegistroVenta();
});

var productos = [];
const listarVendedor = () => {

    $('#selectVendedor option').remove();
    $.get('VendedorController', {opcion: 1}, (data) => {
        const vendedores = JSON.parse(data);
        console.table(vendedores);
        $('#selectVendedor').append(`  <option value="o" disabled selected>Vendedor: </option>`);
        vendedores.forEach(
                (vendedor) => {
            $('#selectVendedor').append(`
                    
                    <option value="${vendedor.idPersona}">${vendedor.nombrePersonas}</option>
                `);
        }
        );

    });
};


const listarSucursal = () => {

    $('#selectSucursal option').remove();
    $.get('SucursalController', {opcion: 1}, (data) => {
        const sucursales = JSON.parse(data);
        console.table(sucursales);
        $('#selectSucursal').append(`  <option value="o" disabled selected>Sucursal: </option>`);
        sucursales.forEach(
                (sucursal) => {
            $('#selectSucursal').append(`
                    
                    <option value="${sucursal.idSucursal}">${sucursal.nombreSucursal}</option>
                `);
        }
        );

    });
};


const listarCliente = () => {

    $('#selectCliente option').remove();
    $.get('ClienteController', {opcion: 1}, (data) => {
        const clientes = JSON.parse(data);
        console.table(clientes);
        $('#selectCliente').append(`  <option value="o" disabled selected>Cliente: </option>`);
        clientes.forEach(
                (cliente) => {
            $('#selectCliente').append(`
                    
                    <option value="${cliente.idCliente}">${cliente.nombrePersonas}</option>
                `);
        }
        );

    });
};


const listarProducto = () => {
    $('#selectProducto option').remove();
    $.get('ProductoController', {opcion: 1}, (data) => {
        const productosData = JSON.parse(data);
        console.table(productos);
        productos = [...productosData];
        $('#selectProducto').append(`  <option value="o" disabled selected>Producto: </option>`);
        productosData.forEach(
                (producto) => {
            $('#selectProducto').append(`
                    <option value="${producto.idProducto}">${producto.nombreProductos}</option>
                `);
        }
        );

    });
};

const agregarProducto = () => {
    const idProducto = Number($('#selectProducto').val());

    const productoEncontrado = productos.find((producto) => producto.idProducto === idProducto);
    console.log(productoEncontrado);
    $('#cajaNombreProducto').val(productoEncontrado.nombreProductos);
    $('#cajaPrecioProducto').val(productoEncontrado.precioProductos);
    $('#cajaStockProducto').val(productoEncontrado.stockProductos);
    $('#txtIdProducto').val(productoEncontrado.idProducto);
};


const registrarVenta = () => {
    const idSucursal = Number($('#selectSucursal').val());
    const idCliente = Number($('#selectCliente').val());
    const idUsuario = Number($('#selectVendedor').val());
    const idProducto = Number($('#idProducto').val());
    const cantidadDetalle = Number($('#cajaCantidad').val());
    const stockProducto = Number($('#cajaStockProducto').val());

    if (cajaCantidad > stockProducto) {
        Swal.fire({
            icon: 'error',
            title: 'Ops...',
            text: 'La cantidad ingresada sobrepasa el Stock',
            footer: 'Vuelva a Ingresar una Cantidad que no pase el stock'
        })
        return;
    } else if (cajaCantidad === 0) {
        Swal.fire({
            title: 'Error!',
            text: 'Porfavor Ingrese la cantidad.',
            imageUrl: 'https://unsplash.it/400/200',
            imageWidth: 400,
            imageHeight: 200,
            imageAlt: 'Custom image',
        })
        return;
    }
    ;

    const ventaNueva = {
        idSucursal,
        idCliente,
        idUsuario
    };
    console.log(ventaNueva);
    const detalleVenta = {
        idProducto,
        precioDetalle: cantidadDetalle * stockProducto,
        cantidadDetalle
    };
    console.log(detalleVenta);
    const venta = JSON.stringify({...ventaNueva});
    const detalle = JSON.stringify({...detalleVenta});
    $.post('detalleVenta', {opcion: 2, ventaNueva: venta, detalleVenta: detalle}, () => {

        alert('VentaAgregada  correctamente');
        // formatear el formulario
        $('#selectSucursal').val('o');
        $('#selectCliente').val('o');
        $('#selectVendedor').val('o');

        listarRegistroVenta();

    });
};


const listarRegistroVenta = () => {
    console.log("Estas juncionando");
    $('#tblRealizarVenta tbody tr').remove();
    $.get('detalleVenta', {opcion: 1}, (data) => {
        ventas = JSON.parse(data);
        console.table(ventas);
        ventas.forEach(
                (venta) => {
            $('#tblRealizarVenta tbody').append(`
                    <tr>
                        <td>${venta.nombreSucursales}</td>
                        <td>${venta.nombreEmpleados}</td>
                        <td>${venta.nombreCliente}</td>
                        <td>${venta.fechaVentas}</td>
                        <td><a href='#' onclick='mostrarDetalleVenta(${venta.idVentas})'><i class="fa-solid fa-eye"></i></a></td>
                    </tr>
                `);
        });
    });

};

const mostrarDetalleVenta = (idVentas) => {
    $('#staticBackdrop').modal();
    $('#tblDetalleCompraProducto tbody tr').remove();
    $.get('detalleVenta', {opcion: 3, idVentas}, (data) => {
        let detalleVentas = JSON.parse(data);
        console.table(detalleVentas);
        detalleVentas.forEach(
                (detalleVenta) => {
                    $('#tblRealizarVenta tbody').append(`
                    <tr>
                        <td>${detalleVenta.cantidadDetalles}</td>
                        <td>${detalleVenta.nombreProductos}</td>
                        <td>${detalleVenta.precioDetalles}</td>
                        <td>${detalleVenta.nombreCategoria}</td>
                    </tr>
                `);
        })
    });
};