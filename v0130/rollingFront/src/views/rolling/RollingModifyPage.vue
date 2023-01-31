<template>
  <RollingLayout>
    <h1>Rolling Modify Page</h1>
    <hr>
    <suspense>
      <template #fallback>
        Loading.....
      </template>
      <template #default>
        <RollingModifyComponent :id="props.id" @handleClickButton="handleClickButton"></RollingModifyComponent>
      </template>
    </suspense>
  </RollingLayout>
</template>

<script setup>
import RollingModifyComponent from "@/components/rolling/RollingModifyComponent.vue";
import RollingLayout from "@/layouts/default/RollingLayout.vue";
import {useRouter} from "vue-router";

const router = useRouter()

const props = defineProps(['id'])

const handleClickButton = () => {
  router.push({name: 'RollingList'})
}


</script>

<style scoped>

</style>
