import { atom } from 'recoil';
import {getListAddress} from "../services/addressService";

const ADDRESS_LIST = 'addressListData';
const CREATE_ADDRESS = 'createAddressa';

export const addressListState = atom({
    key: ADDRESS_LIST,
    default: getListAddress()
});


