<template>
  <RollingLayout>
    <h1>Rolling Detail Page</h1>
    <hr>
    <suspense>
      <template #fallback>
        Loading..
      </template>
      <template #default>
        <RollingDetailComponent :id="props.id" @moveModifyPage="moveModifyPage"></RollingDetailComponent>
      </template>
    </suspense>
  </RollingLayout>
</template>

<script setup>
import RollingDetailComponent from "@/components/rolling/RollingDetailComponent.vue";
import {useRouter} from "vue-router";
import RollingLayout from "@/layouts/default/RollingLayout.vue";

const router = useRouter();
const props = defineProps(['id'])

const moveModifyPage = () => {
  router.push({name: 'RollingModify'})
}

</script>

<style scoped>

</style>
