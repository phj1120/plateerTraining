import { createRouter, createWebHistory } from 'vue-router'
import {tr} from "vuetify/locale";

const routes = [
  {
    path: '/',
    redirect: '/rolling/list',
  },
  {
    path: '/rolling',
    name: 'Rolling',
    redirect: '/rolling/list',
    children: [
      {
        path: 'list',
        name: 'RollingListPage',
        component: () => import('@/views/rolling/RollingListPage.vue')
      },
      {
        path: 'add',
        name: 'RollingAddPage',
        component: () => import('@/views/rolling/RollingAddPage.vue')
      },
      {
        path: 'detail/:id',
        name: 'RollingDetailPage',
        component: () => import('@/views/rolling/RollingDetailPage.vue'),
        props: true
      },
      {
        path: 'modify/:id',
        name: 'RollingModifyPage',
        component: () => import('@/views/rolling/RollingModifyPage.vue'),
        props: true
      },
    ]
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: () => import('@/views/common/LoginPage.vue')
  },
  {
    path: '/logout',
    name: 'LogoutPage',
    component: () => import('@/views/common/LogoutPage.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
