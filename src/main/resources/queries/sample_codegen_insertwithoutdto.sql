ALTER PROCEDURE dbo.sample_codegen_insertwithoutdto
    (
    @id int =0,
    @username varchar(10) = null,
    @age int =0

    )

    AS

    set nocount on
    set transaction isolation level read uncommitted

    INSERT INTO dbo.SAMPLE_TEST_TBL
    VALUES (@ID, @username,@AGE)


    IF @@ERROR = 0
    BEGIN
    SELECT 'SUCCESS' AS RESULT
    END


	