<template>
  <h2>Todo Input</h2>
  <v-form v-model="valid">
    <v-container>
      <v-row>
        <v-col cols="6" md="4">
          <v-text-field
            v-model="todo.content"
            label="CONTENT"
            required
          ></v-text-field>
        </v-col>
        <v-col cols="6" md="4">
          <v-text-field
            v-model="todo.writer"
            label="WRITER"
            required
          ></v-text-field>
        </v-col>
        <v-col>
          <v-btn>Add</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

</template>

<script setup>

import {ref} from "vue";

const todo = ref({})

</script>

<style scoped>

</style>
