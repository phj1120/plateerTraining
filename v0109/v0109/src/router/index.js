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
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "home" */ '@/views/Home.vue'),
      },
    ],
  },
  // {
  //   path: '/todo',
  //   name: 'todo',
  //   redirect: () => '/todo/list',
  //   children: [
  //     {
  //       path: '/list',
  //       name: 'TodoListPage',
  //       component: () => import('@/views/todo/TodoListPage.vue')
  //     },
  //     {
  //       path: '/read/:id',
  //       name: 'TodoReadPage',
  //       component: () => import('@/views/todo/TodoReadPage.vue')
  //     }
  //   ]
  // },
  {
    path: '/todo/list',
    name: 'TodoListPage',
    component: () => import('@/views/todo/TodoListPage.vue')
  },
  {
    path: '/todo/read/:id',
    name: 'TodoReadPage',
    component: () => import('@/views/todo/TodoReadPage.vue'),
  },
  {
    path: '/todo/add',
    name: 'TodoAddPage',
    component: () => import('@/views/todo/TodoAddPage.vue'),
  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: () => import('@/views/MyPage.vue'),
    meta: {requireAuth: true}
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: () => import('@/views/LoginPage.vue')
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFoundPage',
    component: () => import('@/views/NotFoundPage.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})


router.beforeEach((to, from) => {
  console.log(to)
  console.log(from)

  if (to.meta.requireAuth) {
    console.log("required login")
    if (!localStorage.getItem('login')) {
      console.log('login first')

      return "/login"
    }
  }
})

export default router
