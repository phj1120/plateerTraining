<template>
  <br>
  <br>
  <br>
  <v-form>
    <v-container>
      <v-row class="justify-center">
        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.target" label="Target" required></v-text-field>
        </v-col>
        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.imgSrc" label="Image" required></v-text-field>
        </v-col>
        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.title" label="Title" required></v-text-field>
        </v-col>
        <v-col cols="12" md="7">
          <v-btn class="ma-xl-auto" color="success" @click="clickAdd" style="float: right">ADD</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script setup>
import {ref} from "vue";
import {addRolling} from "@/apis/rolling/RollingApis";

const rolling = ref({target: null, imgSrc: null, title: null})

const emits = defineEmits(['handleMoveList'])
const clickAdd = async () => {
  const res = await addRolling(rolling.value)
  // TODO 응답 결과에 따른 처리
  emits('handleMoveList')
}
</script>

<style scoped>

</style>
