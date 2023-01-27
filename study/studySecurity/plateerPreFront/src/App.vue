<template>
  <v-app id="inspire">
    <v-system-bar>
      <v-icon @click.stop="drawer = !drawer">mdi-square</v-icon>
<!--      <v-icon>mdi-circle</v-icon>-->
<!--      <v-icon>mdi-triangle</v-icon>-->
    </v-system-bar>

    <v-navigation-drawer v-model="drawer">
      <v-sheet color="grey-lighten-4" class="pa-4">
        <v-avatar class="mb-4" color="grey-darken-1" size="64"></v-avatar>
        <div>plateer@plateer.com</div>
      </v-sheet>

      <v-divider></v-divider>

      <v-list>
        <v-list-item v-for="link in links" :key="link.icon" :to="{name: link.name}" link>

          <template v-slot:prepend>
            <v-icon>{{ link.icon }}</v-icon>
          </template>

          <v-list-item-title>{{ link.text }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <v-container class="py-8 px-6" fluid>
        <suspense>
          <template #fallback>
            loading...
          </template>
          <template #default>
            <router-view />
          </template>
        </suspense>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
  import {ref} from "vue";

  const drawer = ref(true)
  const links = ref([
    { icon: 'mdi-domain', text: 'Home', name: 'HomePage' },
    { icon: 'mdi-account', text: 'Rollingpaper', name: 'RollingList' },
    { icon: 'mdi-login', text: 'Login', name: 'LoginPage' },
    { icon: 'mdi-logout', text: 'Logout', name: 'LogoutPage' },
  ])
</script>
