// Composables
import {createRouter, createWebHistory} from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/rolling/list'
  },
  {
    path: '/rolling',
    children: [{
      path: 'list',
      name: 'RollingList',
      component: () => import('@/views/rolling/RollingListPage.vue'),
    },
      {
        path: 'add',
        name: 'RollingAdd',
        component: () => import('@/views/rolling/RollingAddPage.vue'),
      },

      {
        path: 'detail/:id',
        name: 'RollingDetail',
        component: () => import('@/views/rolling/RollingDetailPage.vue'),
        props : true,
      },
      {
        path: 'modify/:id',
        name: 'RollingModify',
        component: () => import('@/views/rolling/RollingModifyPage.vue'),
        props : true,
      },
    ],
  },

  {
    path: '/signIn',
    name: 'SignIn',
    component: () => import('@/views/member/SignInPage.vue'),
  },
  {
    path: '/signUp',
    name: 'SignUp',
    component: () => import('@/views/member/SignUpPage.vue'),
  },
  {
    path: '/logout',
    name: 'Logout',
    redirect: '/rolling'
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
