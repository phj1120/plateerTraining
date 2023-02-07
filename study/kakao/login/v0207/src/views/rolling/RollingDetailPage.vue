<template>
  <BaseLayout>
    <v-col cols="11" style="margin: 0 auto">
      <RollingDetailComponent :id="props.id" @handleMoveModify="handleMoveModify" @handleMoveList="handleMoveList"></RollingDetailComponent>
    </v-col>
  </BaseLayout>
</template>

<script setup>
  import BaseLayout from "@/layouts/rolling/BaseLayout.vue";
  import RollingDetailComponent from "@/components/rolling/RollingDetailComponent.vue";
  import {useRoute, useRouter} from "vue-router";

  const props = defineProps(['id'])

  const route = useRoute()
  const router = useRouter()


  const handleMoveList = () => {
    router.push({ name: 'RollingListPage', query: route.query})
  }

  const handleMoveModify = () => {
    router.push({ name: 'RollingModifyPage', query: route.query})
  }
</script>

<style scoped>

</style>
