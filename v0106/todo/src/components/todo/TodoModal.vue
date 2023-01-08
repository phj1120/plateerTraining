<template>
  <v-row justify="center">
    <v-dialog
      v-model="removeDialog.open"
      persistent
    >
      <v-card>
        <v-card-title class="text-h5">
          삭제 하시겠습니까?
        </v-card-title>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="green-darken-1"
            variant="text"
            @click="dialog = false"
          >
            Disagree
          </v-btn>
          <v-btn
            color="green-darken-1"
            variant="text"
            @click="emits('handleClickRemoveAgree', removeId)"
          >
            Agree
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script setup>
import {toRef} from "vue";

const props = defineProps(['removeId', 'removeDialog'])
const emits = defineEmits(['handleClickRemoveAgree'])

const dialog = toRef(props.removeDialog, 'open')
</script>

<style scoped>

</style>
