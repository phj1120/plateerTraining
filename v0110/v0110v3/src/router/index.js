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
        component: () => import('@/views/Home.vue'),
      }, {
        path: 'login',
        name: 'LoginPage',
        component: () => import('@/views/LoginPage.vue')
      },
      {
        path: 'logout',
        name: 'LogoutPage',
        meta: {'authorized': true},
        component: () => import('@/views/LogoutPage.vue')
      },
      {
        path: 'm1',
        name: 'M1Page',
        component: () => import('@/views/M1Page.vue')
      },
      {
        path: 'm2',
        name: 'M2Page',
        meta: {'authorized': true},
        component: () => import('@/views/M2Page.vue')
      }
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

router.beforeEach((to) => {
  // 권한이 있는 페이지의 경우
  if (to.meta.authorized) {
    // 쿠키에서 권한을 확인 한다. // pinia 라우터에서 사용 불가능 하므로.
    const id = VueCookies.get('id')
    // 아이디가 없는 경우 로그인 페이지로 이동
    if (!id) {
      return '/login'
    }
  }
})

export default router
