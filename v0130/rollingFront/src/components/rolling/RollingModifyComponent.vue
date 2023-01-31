<template>
  <h2>Rolling Modify Component</h2>
  <v-form validate-on="submit">
    <v-text-field v-model="rolling.id" label="ID" readonly></v-text-field>
    <v-text-field v-model="rolling.name" label="NAME"></v-text-field>
  </v-form>

  <div class="text-center">
    <v-dialog v-model="dialog">
      <template v-slot:activator="{ props }">
        <v-btn v-bind="props" @click="clickMod">수정</v-btn>
        <v-btn v-bind="props" @click="clickDel">삭제</v-btn>
      </template>

      <v-card>
        <v-card-text>
          완료되었습니다.
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary" block @click="clickClose">닫기</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>

</template>

<script setup>
import {getRolling, modifyRolling, deleteRolling} from "@/apis/rolling/RollingApis";
import {ref} from "vue";

const props = defineProps(['id'])
const emits = defineEmits(['handleClickButton'])

const data = await getRolling(props.id)
const rolling = ref({id: data.id, name: data.name})
const dialog = ref(false)

const clickClose = () => {
  dialog.value = !dialog.value
  emits('handleClickButton')
}

const clickMod = async () => {
  await modifyRolling(rolling.value)
}

const clickDel = async () => {
  await deleteRolling(rolling.value.id)
}

</script>

<style scoped>

</style>
