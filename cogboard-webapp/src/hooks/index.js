import { useState } from 'react';

export const useDialogToggle = () => {
  const [dialogOpened, setDialogOpened] = useState(false);

  const openDialog = () => setDialogOpened(true);
  const handleDialogClose = () => setDialogOpened(false);

  return [dialogOpened, openDialog, handleDialogClose];
};

export const useFormData = (data) => {
  const [values, setValues] = useState(data);

  const handleChange = fieldName => event => {
    const { target: { type, value, checked } } = event;
    const valueType = {
      checkbox: checked,
      number: Number(value),
    };
    const fieldValue = valueType[type] !== undefined ? valueType[type] : value;

    setValues({ ...values, [fieldName]: fieldValue});
  };

  return { values, handleChange };
};