<template>
  <h1>Todo List</h1>
  <div class="tableWrapper">
    <v-table>
      <thead>
      <tr>
        <th class="text-left">
          ID
        </th>
        <th class="text-left">
          TITLE
        </th>
        <th class="text-left">
          WRITER
        </th>
      </tr>
      </thead>
      <tbody>

      <tr v-for="todo in arr" :key="todo.id">
        <td>{{ todo.id }}</td>
        <td>{{ todo.title }}</td>
        <td>{{ todo.writer }}</td>
        <v-btn @click="() => handleChangeDialog(todo.id)">x</v-btn>
      </tr>
      </tbody>
    </v-table>
  </div>

  <!--모달-->
  <template>
    <v-row justify="center">
      <v-dialog
        v-model="dialog"
        persistent
      >
        <template v-slot:activator="{ props }">
          <v-btn
            color="primary"
            v-bind="props"
          >
            Open Dialog
          </v-btn>
        </template>
        <v-card>
          <v-card-title class="text-h5">
            Use Google's location service?
          </v-card-title>
          <v-card-text>Let Google help apps determine location. This means sending anonymous location data to Google, even when no apps are running.</v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="green-darken-1"
              variant="text"
              @click="dialog = false"
            >
              CANCEL
            </v-btn>
            <v-btn
              color="green-darken-1"
              variant="text"
              @click="callDeleteTodo(temp)"
            >
              DELETE
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </template>

</template>

<script setup>
import {ref, watch} from "vue";
import {deleteTodo, getTodoList} from "@/apis/todoAPI";

const props = defineProps(['count'])
const emits = defineEmits(['changeCount'])
const arr = ref([])

getTodoList().then(result => {
  arr.value = result
})

const dialog = ref(false)
var temp = ref(0)
const handleChangeDialog = (id)=>{
  dialog.value = true
  temp.value = id
}

const callDeleteTodo = async (id)=>{
  const isDelete = await deleteTodo(id)

  if(isDelete){
    dialog.value = false
    emits('changeCount')
  }
}


watch(() => props.count, () => {
  console.log("watch..")
  getTodoList().then(result => {
    console.log(result)
    arr.value = result
  })
})



</script>

<style scoped>
.tableWrapper {
  width: 50vw;
  border: 1px solid black;
}
</style>
