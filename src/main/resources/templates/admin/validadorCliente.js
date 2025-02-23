    const token = localStorage.getItem('token');
if (token) {
// Agregar el token en la cabecera de las solicitudes para mantener la sesión
fetch('/admin/dashboard', {
    headers: {
        'Authorization': `Bearer ${token}`
    }
})
.then(response => {
    if (response.ok) {
        // Mostrar el contenido de la página
    } else {
        // Manejar error de autenticación, redirigir a login
        window.location.href = '/auth/login';
    }
});
} else {
// Si no hay token, redirigir al login
window.location.href = '/auth/login';
}