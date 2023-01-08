<template>
  <v-row justify="center">
    <v-dialog
      v-model="modifyDialog.open"
      persistent
    >
      <v-card>
        <v-card-title class="text-h5">
          수정
        </v-card-title>
        <v-card-actions>
          <v-row>
            <v-col cols="6" md="4">
              <v-text-field
                v-model="modifyTodo.title"
                label="TITLE"
              ></v-text-field>
            </v-col>
            <v-col cols="6" md="4">
              <v-text-field
                v-model="modifyTodo.writer"
                label="WRITER"
                required
              ></v-text-field>
            </v-col>
          </v-row>

          <v-spacer></v-spacer>
          <v-btn
            color="green-darken-1"
            variant="text"
            @click="open = false"
          >
            취소
          </v-btn>
          <v-btn
            color="green-darken-1"
            variant="text"
            @click="handleClickModifyAgree(id, modifyTodo)"
          >
            수정
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script setup>
import {ref, toRef, watch} from "vue";
import {putTodo} from "@/apis/TodoApis";

const props = defineProps(['modifyDialog'])
const emits = defineEmits(['refreshTodos'])
const open = toRef(props.modifyDialog, 'open')
const id = toRef(props.modifyDialog, 'id')

let modifyTodo = {title: '', writer: ''}
watch(() => props.modifyDialog.id, () => {
  modifyTodo = ref({
    title: props.modifyDialog.todo.title,
    writer: props.modifyDialog.todo.writer
  })
})

const handleClickModifyAgree = (id, todo) => {
  modifyAgree(id, todo)
};

const modifyAgree = (id, todo) => {
  putTodo(id, todo).then(() => {
    emits('refreshTodos')
    open.value = false
  })
}


</script>

<style scoped>

</style>
