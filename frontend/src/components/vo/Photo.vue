<template>
    <div>
        <v-card-title v-if="editMode">
            {{label}}
        </v-card-title>

        <v-img
            :key="photoRender"
            style="width:400px; height:300px; border-radius:10px; position:relative; margin-left:5px; top:5px;"
            :style="editMode ? 'cursor:pointer;':''"
            :src="value.imgFile ? value.imgFile:'https://cdn.vuetifyjs.com/images/cards/cooking.png'"
            class="mx-auto"
            @click="selectFile()"
        ></v-img>

        <v-card-text v-if="value">
            <div v-if="editMode">
                <v-text-field label="" v-model="value.imgName"/>
                <slot name="actions"></slot>
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name:"Photo",
        props: {
            editMode: Boolean,
            value : Object,
            label : String, 
        },
        data: () => ({
            photoRender:0
        }),
        created(){
            if(!this.value) {
                this.value = {
                    'imgName': '',
                    'imgFile': '',
                };
            }
        },
        watch: {
            value(newVal) {
                this.$emit('input', newVal);
            },
        },
        methods: {
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }

                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.value.imgFile = result;
                        me.photoRender++;
                    };
                    reader.readAsDataURL( file );
                };
            },
        }
    }
</script>

<style scoped>
</style>
