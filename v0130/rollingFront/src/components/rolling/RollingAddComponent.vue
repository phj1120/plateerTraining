<template>
  <h2>Rolling Add Component</h2>
  <v-form validate-on="submit">
    <v-text-field v-model="rolling" label="NAME"></v-text-field>
  </v-form>

  <div class="text-center">
    <v-dialog v-model="dialog">
      <template v-slot:activator="{ props }">
        <v-btn :to="{name: 'RollingList'}">취소</v-btn>
        <v-btn v-bind="props" @click="clickAdd">추가</v-btn>
      </template>

      <v-card>
        <v-card-text>
          완료되었습니다.
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary" block :to="{name:'RollingList'}">닫기</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>

</template>

<script setup>
import {ref} from "vue";
import {addRolling} from "@/apis/rolling/RollingApis";

const dialog = ref(false)

const rolling = ref([])

const clickAdd = async () => {
  await addRolling(rolling.value)
}

</script>

<style scoped>

</style>
