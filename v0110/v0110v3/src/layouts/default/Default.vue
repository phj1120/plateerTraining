<template>
  <v-app>
    <default-bar/>
    <v-main>
      <app-bar></app-bar>
      <router-view />
    </v-main>
  </v-app>
</template>

<script setup>
import DefaultBar from './AppBar.vue'
</script>
