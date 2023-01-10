<template>
  <v-app-bar flat>
    <v-app-bar-title>
      <router-link v-for="menu in useStore.showMenus" :key="menu.path" :to="menu.path">
        <v-btn>
          {{ menu.name }}
        </v-btn>
      </router-link>
    </v-app-bar-title>
  </v-app-bar>
</template>

<script setup>
import useAuth from "@/store/useAuth";

const useStore = useAuth()
</script>
