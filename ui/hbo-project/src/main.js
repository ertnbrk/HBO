import { createApp } from 'vue';  // Vue 3 için createApp fonksiyonunu kullanıyoruz
import App from './App.vue';
import router from './router';

const app = createApp(App);
app.use(router); // Router'ı kullanıyoruz
app.mount('#app'); // Uygulamayı monte ediyoruz
import './style/style.css';
