<template>
  <ReadWriteModifyLayout>
    <template #default>
      <TodoReadComponent @moveTodoModifyPage="moveTodoModifyPage"
                         @MoveTodoListPage="MoveTodoListPage"></TodoReadComponent>
    </template>
  </ReadWriteModifyLayout>
</template>

<script setup>
import {useRouter} from "vue-router";
import TodoReadComponent from "@/components/todo/TodoReadComponent.vue";
import ReadWriteModifyLayout from "@/layouts/todo/ReadWriteModifyLayout.vue";

const router = useRouter();

const moveTodoModifyPage = (id) => {
  router.push({name: 'TodoModifyPage', params: {id}})
}

const MoveTodoListPage = () => {
  router.push({name: 'TodoListPage'})
}
</script>

<style scoped>

</style>
