import {createRouter, createWebHistory} from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/rolling/list',
  },
  {
    path: '/rolling',
    children: [
      {
        path: 'list',
        name: 'RollingList',
        component: () => import('@/views/rollings/RollingListPage.vue')
      },
      {
        path: 'detail/:id',
        name: 'RollingDetail',
        component: () => import('@/views/rollings/RollingDetailPage.vue')
      },
    ]
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
