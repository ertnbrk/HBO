<template>
    <nav class="navbar">
      <div class="container">
        <div class="navbar-brand">
          <a href="/" class="navbar-item">
            <h2>Event App</h2>
          </a>
        </div>
        <div class="navbar-menu">
          <div class="navbar-end">
          <router-link to="/" class="navbar-item" active-class="active">Home</router-link>
          <router-link to="/login" class="navbar-item" active-class="active">Login</router-link>
          <router-link to="/create-event" class="navbar-item">Create Event</router-link>
          <router-link to="/events" class="navbar-item">Events</router-link>
          </div>
        </div>
      </div>
    </nav>
  </template>
  
  <script>
  export default {
    name: 'Navbar-Comp',
  };
  </script>
  
  <style scoped>
  /* Navbar */
.navbar {
  background-color: #333;
  color: white;
  padding: 1rem;
}

.navbar-item {
  color: white;
  text-decoration: none;
  padding: 10px;
}

.navbar-item:hover {
  background-color: #555;
  color: #f39c12; /* Hoverda renk değişimi */
}

/* Aktif navbar linki için */
.navbar-item.active {
  color: #f39c12; /* Aktif link rengi */
  background-color: transparent; /* Arka plan rengini sıfırla */
}

  </style>
  