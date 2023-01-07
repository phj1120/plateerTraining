<template>
  <v-form v-model="valid">
    <v-container>
      <v-row>
        <v-col cols="6" md="4">
          <v-text-field
            v-model="props.todo.content"
            label="CONTENT"
          ></v-text-field>
        </v-col>
        <v-col cols="6" md="4">
          <v-text-field
            v-model="props.todo.writer"
            label="WRITER"
            required
          ></v-text-field>
        </v-col>
        <v-col>
          <v-btn @click="emits('clickAdd')">Add</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script setup>
const props = defineProps(['todo'])
const emits = defineEmits(['clickAdd'])
</script>


<style scoped>

</style>
