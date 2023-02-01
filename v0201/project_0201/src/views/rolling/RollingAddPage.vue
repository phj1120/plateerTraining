<template>
  <BaseLayout>
    <RollingAddComponent @handleMoveList="handleMoveList"></RollingAddComponent>
  </BaseLayout>
</template>

<script setup>
import BaseLayout from "@/layouts/rolling/BaseLayout.vue";
import RollingAddComponent from "@/components/rolling/RollingAddComponent.vue";
import {useRoute, useRouter} from "vue-router";


const route = useRoute()
const router = useRouter()
const handleMoveList = () => {
  router.push({name: 'RollingListPage', query: route.query})
}
</script>

<style scoped>

</style>
