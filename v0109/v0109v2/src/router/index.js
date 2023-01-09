// Composables
import {createRouter, createWebHistory} from 'vue-router'

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
    path: '/todo',
    name: 'TodoPage',
    redirect: () => '/todo/list',
    children: [
      {
        path: 'list',
        name: 'TodoListPage',
        component: () => import('@/views/todo/TodoListPage.vue'),
      },
      {
        path: 'read/:id',
        name: 'TodoReadPage',
        component: () => import('@/views/todo/TodoReadPage.vue'),
      },
      {
        path: 'add',
        name: 'TodoAddPage',
        component: () => import('@/views/todo/TodoAddPage.vue')
      },
      {
        path: 'modify/:id',
        name: 'TodoModifyPage',
        component: () => import('@/views/todo/TodoModifyPage.vue')
      }
    ]
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
