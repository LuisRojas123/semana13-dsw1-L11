const React = require('react');
const client = require('../client');
const { Link, useParams, } = require('react-router-dom');
const {useState, useEffect} = require('react');


const PageVerVenta = () => {

    let { id } = useParams();
    const [venta, setVenta] = useState({});
    const [ventadetalles, setVentaDetalles] = useState([]);
    useEffect(() => {
        url_venta = '/api/ventas/' + id
        client({
            method: 'GET',
            path: url_venta
        }).done(response => setVenta(response.entity));
        client({
            method: 'GET',
            path: url_venta + '/formacion'
        }).done(response => setVentaDetalles(response.entity))
        
    }, []);


    return (
        <>
            <h1>Venta</h1>
            <table border="1">
                <tbody>
                    <tr>
                        <th>Total</th>
                        <td>{venta.total}</td>
                    </tr>
                </tbody>
            </table>

            <hr />

            <h2>Detalle De Venta</h2>

            <table border="1">
                <thead>
                    <tr>
                        <th>NOMBRE</th>
                        <th>PRECIO</th>
                        <th>CANTIDAD</th>
                    </tr>
                </thead>
                <tbody>

                    {ventadetalles.map(ventadetalle => {

                        return (
                            <tr key={ventadetalle.ID}>
                                <td>{ventadetalle.NOMBRE}</td>
                                <td>{ventadetalle.PRECIO}</td>
                                <td>{ventadetalle.CANTIDAD}</td>
                            </tr>
                        )

                    })}

                </tbody>
            </table>
            <hr />
            <Link to={`/ver-venta/${id}/nuevo-detalle`}>Agregar Detalle Venta</Link> |  
            <Link to="/">Volver</Link>
            
        </>
    )
}

module.exports = PageVerVenta;