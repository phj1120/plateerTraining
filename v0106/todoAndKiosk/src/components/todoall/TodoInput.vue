<template>
  <h1>Todo Input</h1>
  <v-form v-model="valid">
    <v-container>
      <v-row>
        <v-col
          cols="12"
          md="12"
        >
          <v-text-field
            v-model="todo.title"
            label="TITLE"
            required
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
          md="12"
        >
          <v-text-field
            v-model="todo.writer"
            label="WRITER"
            required
          ></v-text-field>
        </v-col>
      </v-row>

      <v-btn variant="" @click="handleClickAdd">
        ADD
      </v-btn>
    </v-container>
  </v-form>
</template>

<script setup>
import {ref} from "vue";
import {postTodo} from "@/apis/todoAPI";

const emits = defineEmits(['changeCount'])

const todo = ref({title: 'MyTitle..', writer: 'user123'})

const handleClickAdd = async () => {
  const temp = todo.value
  const result = await postTodo(temp)

  emits("changeCount")
}

</script>

<style scoped>

</style>
