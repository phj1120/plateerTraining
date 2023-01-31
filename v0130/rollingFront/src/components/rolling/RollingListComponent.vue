<template>
  <h2>Rolling List Component</h2>
  <v-list>
    <v-list-item v-for="paper in rolling" :key="paper.id" @click="emits('moveDetailPage', paper.id)">
      {{ paper.name }}
    </v-list-item>
  </v-list>
</template>

<script setup>
import {getRollingList} from "@/apis/rolling/RollingApis";
import {ref} from "vue";


const data = await getRollingList()
const rolling = ref(data)


const emits = defineEmits(['moveDetailPage'])
</script>

<style scoped>

</style>
