<template>
  <v-form v-model="valid">
    <v-container>
      <v-row>
        <v-col cols="6" md="4">
          <v-text-field
            v-model="todo.title"
            label="TITLE"
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
          <v-btn @click="handelClickAdd()">Add</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script setup>
import {postTodo} from "@/apis/TodoApis";
import {ref} from "vue";

const todo = ref({title: '', writer: ''})
const emits = defineEmits(['refreshTodos'])

const handelClickAdd = () => {
  addTodo()
}

const addTodo = () => {
  postTodo({writer: todo.value.writer, title: todo.value.title})
    .then(() => {
        emits('refreshTodos')
        todo.value = {title: '', writer: ''}
      }
    );
}


</script>


<style scoped>

</style>
