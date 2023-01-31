<template>
  <v-app id="inspire">
    <v-app-bar floating>
      <v-container class="fill-height d-flex align-center bg-color">
        <v-avatar class="me-10 ms-4" color="white" size="32"></v-avatar>
        <v-btn v-for="menu in menus" :key="menu.name" variant="text" :to="{name: menu.name}">{{ menu.title }}</v-btn>
      </v-container>
    </v-app-bar>
    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col>
            <v-sheet min-height="90vh" rounded="lg">
              <slot></slot>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>

import {ref} from "vue";

const menus = ref([
  {name: 'RollingList', path: '/rolling/list', title: '목록'},
  {name: 'SignIn', path: '/signIn', title: '로그인'}
]);

</script>

<style scoped>
ul {
  display: flex;
}

ul li {
  list-style: none;
  margin-left: 20px;
  font-size: 30px;
}

.bg-color {
  background-color: lightblue;
}
</style>
