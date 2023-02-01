<template>
  <br>
  <br>
  <br>
  <v-form>
    <v-container>
      <v-row class="justify-center">
        <v-col cols="12" md="7">
          <v-text-field v-model="rollingInfo.target" label="Target" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rollingInfo.imgSrc" label="Image" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rollingInfo.wno" label="Writer" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rollingInfo.createDt" label="Create Date" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-btn class="ma-xl-auto" color="success" @click="handlClickAdd" style="float: right">ADD</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script setup>
import {ref} from "vue";
import {addRolling} from "@/apis/rolling/RollingApis";


const rollingInfo = ref({target: null, imgSrc: null, wno: null, createDt: null})

const emits = defineEmits(['handleMoveList'])
const handlClickAdd = async () => {
  const res = await addRolling(rollingInfo.value)
  emits('handleMoveList')
}
</script>

<style scoped>

</style>
