import {defineStore} from "pinia";
import {computed, ref} from "vue";
import VueCookies from "vue-cookies";

const useAuth = defineStore('useAuth', () => {
  const loginState = ref(false)

  const menus = [
    {name: "Home", path: '/', authorize: false},
    {name: "Login", path: '/login', authorize: false},
    {name: "Logout", path: '/logout', authorize: true},
    {name: "M1", path: '/m1', authorize: false},
    {name: "M2", path: '/m2', authorize: true},
  ]

  const showMenus = computed(() => {
    // 로그인 된 경우
    if (isLogined()) {
      return menus
    }

    // 로그인 안 된 경우
    return menus.filter((menu) => {
      return menu.authorize === loginState.value
    })
  })

  const isLogined = () => {
    if (loginState.value === true)
      return true

    const id = VueCookies.get('id')
    if (id !== null) {
      return true
    }
    return false
  }

  const login = () => {
    // 로그인 요청 시 loginState 값을 true 로 바꿔주고,
    // 새로고침 시에도 반영 되도록, 쿠키에 저장해 줌
    loginState.value = true
    VueCookies.set('id', Date.now(), '1d')
  }

  const logout = () => {
    loginState.value = false
    VueCookies.remove('id')
  }


  return {showMenus, isLogined, login, logout}
})

export default useAuth
