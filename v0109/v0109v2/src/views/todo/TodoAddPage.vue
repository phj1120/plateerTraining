<template>
  <h1>Todo Add Page</h1>
  <ReadWriteModifyLayout>
    <template #default>
      <TodoAddComponent @moveListPage="moveListPage"></TodoAddComponent>
    </template>
  </ReadWriteModifyLayout>
</template>

<script setup>
import ReadWriteModifyLayout from "@/layouts/todo/ReadWriteModifyLayout.vue";
import TodoAddComponent from "@/components/todo/TodoAddComponent.vue";
import {useRouter} from "vue-router";

const router = useRouter();

const moveListPage = () => {
  router.push({name: "TodoListPage"})
}

</script>

<style scoped>

</style>
