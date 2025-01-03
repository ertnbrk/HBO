<template>
  <div id="app">
    <!-- Navbar, sadece hideNavbar false ise görünür -->
    <nav-comp v-if="!$route.meta.hideNavbar"></nav-comp>

    <!-- Ana içerik burada -->
    <router-view></router-view>

    <!-- Footer, sadece hideFooter false ise görünür -->
    <footer-comp v-if="!$route.meta.hideFooter"></footer-comp>
  </div>
</template>

<script>
// Navbar ve Footer bileşenlerini dahil ediyoruz
import NavComp from './components/Navbar-Comp.vue';
import FooterComp from './components/Footer-Comp.vue';

export default {
  name: 'App',
  components: {
    NavComp,
    FooterComp,
  },
};
</script>


<style>
/* Global style updates */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
}

.content {
  min-height: 80vh; /* Ensures the content area does not overflow beyond footer */
  padding: 20px;
}
</style>
