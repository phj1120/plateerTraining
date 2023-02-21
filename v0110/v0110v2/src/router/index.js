// Composables
import {createRouter, createWebHistory} from 'vue-router'
import VueCookies from "vue-cookies";

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        component: () => import(/* webpackChunkName: "home" */ '@/views/Home.vue'),
      },
    ],
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: () => import(/* webpackChunkName: "home" */ '@/views/LoginPage.vue'),
  },
  {
    path: '/logout',
    name: 'LogoutPage',
    component: () => import(/* webpackChunkName: "home" */ '@/views/LogoutPage.vue'),
    meta: {requireAuth: true}
  },
  {
    path: '/m1',
    name: 'M1',
    component: () => import(/* webpackChunkName: "home" */ '@/views/M1Page.vue'),
  },
  {
    path: '/m2',
    name: 'M2',
    component: () => import(/* webpackChunkName: "home" */ '@/views/M2Page.vue'),
    meta: {requireAuth: true}
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

router.beforeEach((to) => {
  if (to.meta.requireAuth) {
    if (VueCookies.get('id')) {
      return
    }
    return '/login'
  }
})

export default router
