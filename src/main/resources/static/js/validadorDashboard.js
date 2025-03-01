const token = localStorage.getItem('token'); // O donde guardes el token
    console.log(token); // Verifica que esté presente antes de realizar la solicitud.

    if (!token) {
    alert('No se ha encontrado el token');
    return;
    }

    const headers = new HttpHeaders({
        'Authorization': `Bearer ${token}`
    });

    this.http.get('http://localhost:8080/api/some-endpoint', { headers })
      .subscribe(response => {
        console.log(response);
      }, error => {
        console.log(error);
      });