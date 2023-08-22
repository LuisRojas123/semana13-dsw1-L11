const React = require('react');
const ReactDOM = require('react-dom');
const {createBrowserRouter, RouterProvider} = require('react-router-dom');

const PageHome = require('./pages/home');

const PageNuevoDetalleVenta = require('./pages/nuevo-detalle-venta');

const router = createBrowserRouter([
	{path: '/', element: <PageHome />},
	{path: '/nuevo-detalle-venta', element: <PageNuevoDetalleVenta />},
])


ReactDOM.render(
	<React.StrictMode>
		<RouterProvider router={router} />
	</React.StrictMode>,
	document.getElementById('react')
)
