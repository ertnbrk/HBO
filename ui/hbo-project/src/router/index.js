import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import LoginPage from '../views/LoginPage.vue';
import SignupPage from '../views/SignupPage.vue';
import CreateEvent from '../components/EventForm'; // Yeni bileşeni içe aktar
import EventList from '@/components/EventList.vue';
const routes = [
  {
    path: '/home',
    name: 'home',
    component: HomePage,
    meta: { hideNavbar: false, hideFooter: false }, // Navbar ve footer görünür
  },
  {
    path: '/',
    name: 'login',
    component: LoginPage,
    meta: { hideNavbar: true, hideFooter: true }, // Navbar ve footer gizli
  },
  {
    path: '/create-event',
    name: 'createEvent',
    component: CreateEvent,
    meta: { hideNavbar: false, hideFooter: false }, // Navbar ve footer gizli
  },
  {
    path: '/events',
    name: 'EventList',
    component: EventList,
    meta: { hideNavbar: false, hideFooter: false }, // Navbar ve footer gizli
  },
  {
    path: '/signup',
    name: 'signup',
    component: SignupPage,
    meta: { hideNavbar: false, hideFooter: false }, // Navbar ve footer görünür
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
