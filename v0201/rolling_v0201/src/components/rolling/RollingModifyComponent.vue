<template>
  <v-form>
    <v-container>
      <v-row class="justify-center">
        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.id" label="ID" readonly></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.title" label="Title" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.target" label="Target" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.imgSrc" label="Image" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.wno" label="Writer" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-text-field v-model="rolling.createDt" label="Create Date" required></v-text-field>
        </v-col>

        <v-col cols="12" md="7">
          <v-btn class="ma-2 ma-xl-auto" color="error" @click="delRollingOne" style="float: right">DEL</v-btn>
          <v-btn class="ma-2 ma-xl-auto" color="success" @click="modeRollingOne" style="float: right">MOD</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

  <v-dialog class="justify-center" v-model="dialog">
    <v-card style="margin: 0 auto; width: 50vw">
      <v-card-text>
        롤링페이퍼 {{ props.id }}번이 정상적으로 처리되었습니다.
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" block @click="handleClickDialog">Close</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script setup>
import {delRolling, getRolling, modRolling} from "@/apis/rolling/RollingApis";
import {onMounted, ref} from "vue";


const props = defineProps(['id'])
const emits = defineEmits(['handleMoveDetail', 'handleMoveList'])
const dialog = ref(false)
const rolling = ref({})


const handleClickDialog = () => {
  dialog.value = !dialog.value
  emits('handleMoveList')
}

const getRollingOne = async () => {
  const res = await getRolling(props.id)
  rolling.value = res.data
  console.log(rolling.value)
}

const modeRollingOne = async () => {
  await modRolling(rolling.value)
  dialog.value = true
}

const delRollingOne = async () => {
  await delRolling(props.id)
  dialog.value = true
}

onMounted(() => {
  getRollingOne()
})
</script>

<style scoped>

</style>
